class Vegetable:
    def __init__(self,name,nepaliName,max_price,min_price,avg_price):
        self.name = name
        self.nepaliName = nepaliName
        self.max_price = max_price
        self.min_price = min_price
        self.avg_price = avg_price

    def __str__(self):
        return f"Vegetable(name={self.name},name2={self.nepaliName}, Max Price={self.max_price}, Min Price={self.min_price}, Avg Price={self.avg_price})"
    

    def getName(self):
        return self.name
    
    def getMaxPrice(self):
        return self.max_price
    
    def getMinPrice(self):
        return self.min_price
    
    def getAvgPrice(self):
        return self.avg_price
    
    def getNepaliName(self):
        return self.nepaliName
    
    

