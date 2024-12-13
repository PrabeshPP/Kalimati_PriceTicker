import requests
from bs4 import BeautifulSoup
import pandas as pd
from datetime import date
from vegetable import Vegetable
from dbSetup import connectDB
from datetime import datetime
import uuid



def fetch_page(url):
    try:
        response = requests.get(url)
        response.raise_for_status()  
        return response.text
    except requests.exceptions.RequestException as e:
        print(f"Error fetching the page: {e}")
        return None


def parse_html(content):
    soup = BeautifulSoup(content, 'html.parser')
    return soup

def extract_data(soup,nameList):

    data = []
    elements = soup.find("div",id="commodityPricesDailyTable")
    tbody = elements.find("tbody")
    data1 = tbody.find_all("tr")



    i = 0
    for item in data1:
        table_Data = item.find_all("td")
        
        product = Vegetable(table_Data[0].text,nameList[i],table_Data[3].text,table_Data[2].text,table_Data[4].text)
        data.append(product)
        i+=1
    
   
    return data


def extract_nepali_data(soup):
    data = []
    elements = soup.find("div",id="commodityPricesDailyTable")
    tbody = elements.find("tbody")
    data1 = tbody.find_all("tr")
    
    for item in data1:
        table_Data = item.find_all("td")
        nepali_vegetable_name = (table_Data[0].text)
        data.append(nepali_vegetable_name)

    return data


def save_data(data, filename="scraped_data.csv"):
    df = pd.DataFrame(data, columns=['Content'])
    df.to_csv(filename, index=False)


#date scrapper for each of the scrapped data
def scrap_date(soup):
    element = soup.find("div",id="commodityPricesDailyTable")
    date_tag = element.find("div",id="vtitle")
    date_str = date_tag.text
    date_list = date_str.split(" ")
    required_date = date_list[3:]
    
    month = required_date[0]
    
    # this has some minor bugs to work on when the day is in double digit
    day = required_date[1][:len(required_date[1])-1]
    year = required_date[2]
    date_str = year+month+day
    date_obj = datetime.strptime(date_str,"%Y%B%d").date()
  

    return date_obj









def main():
    url = 'https://nepalicalendar.rat32.com/vegetable/' 
    url1 = 'https://kalimatimarket.gov.np/'
    page_content = fetch_page(url)
    page_content_nepali = fetch_page(url1)
    soup = parse_html(page_content)
    soup1 = parse_html(page_content_nepali)
    
    if page_content:
        today = scrap_date(soup)
        scrap_nepali_data = extract_nepali_data(soup1)
        
        scraped_data = extract_data(soup,scrap_nepali_data)

        
       

       
    
        connect = connectDB()
        cur = connect.cursor()

      
        
        insert_query = """
        INSERT INTO Vegetables(id,english_name,nepali_name,max_price,min_price,avg_price,date) VALUES(%s,%s,%s,%s,%s,%s,%s);
"""

        

        for i in range(len(scraped_data)):
            veg = scraped_data[i]
            random_uuid  = uuid.uuid4()
            values= (str(random_uuid),veg.getName(),veg.getNepaliName(),veg.getMaxPrice(),veg.getMinPrice(),veg.getAvgPrice(),today)
           
            cur.execute(insert_query,values)
            connect.commit()

        print("Successfully added the today's data to the Database!")
        
        cur.close()
        connect.close()        
       

if __name__ == "__main__":
    main()
