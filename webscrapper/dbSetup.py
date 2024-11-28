import psycopg2

DB_NAME = "Kalimati_Prices"
DB_USER ="postgres"
DB_PASS ="X1y2z3###"
DB_HOST="localhost"
DB_PORT ="5432"

def connectDB():
    connect = psycopg2.connect("dbname=Kalimati_Prices user=postgres")
    print("Connected to DB successfully!")

    return connect



