import os
import psycopg2

from dotenv import load_dotenv,find_dotenv

load_dotenv(find_dotenv())



def connectDB():
    connect = psycopg2.connect(
        user = os.getenv("RDS_USERNAME"),                                      
        password = os.getenv("RDS_PW"),                                  
        host = os.getenv("RDS_URL"),                                            
        port = os.getenv("5432"),                                          
        database = os.getenv("postgres") 

    )
    print("Connected to DB successfully!")

    return connect



