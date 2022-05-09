import mysql.connector
from datetime import datetime
class DB:
    def __init__(self) -> None:
        dbconfig = {
            'host': 'localhost',
            'user': 'root',
            'password': '',
            'database': 'cinepolis'
        }
        self.conn = mysql.connector.connect(**dbconfig)
        self.cursor = self.conn.cursor()
    def get_movies(self):
        _SQL = f"""
            SELECT * FROM movies
        """
        self.cursor.execute(_SQL)
        movies = self.cursor.fetchall()
        return movies

    def get_tickets(self, movieId, cinema_name, date, time):
        _SQL = f"""
            SELECT * FROM tickets 
            WHERE movieId = '{movieId}' AND cinemaName = '{cinema_name}' AND date = '{date}' AND time = '{time}';
            """
        self.cursor.execute(_SQL)
        tickets = self.cursor.fetchall()
        return tickets
    
    def get_orders(self, today):
        _SQL = f"""
            SELECT * FROM tickets WHERE date >= '{today}'
        """
        self.cursor.execute(_SQL)
        orders = self.cursor.fetchall()
        return orders

    def get_theaters(self):
        _SQL = f"""
            SELECT cinemaName, cinemaLocation, cinemaDrawable
            FROM theaters
        """
        self.cursor.execute(_SQL)
        theaters = self.cursor.fetchall()
        return theaters

    def get_theater_from_movieId(self, movieId):
        _SQL = f"""
            SELECT theaters.cinemaName, theaters.cinemaLocation, theaters.cinemaDrawable from theaters 
            LEFT JOIN theater_movies
            ON theaters.cinemaId = theater_movies.cinemaId
            WHERE theater_movies.movieId = {movieId}
        """
        self.cursor.execute(_SQL)
        theaters = self.cursor.fetchall()
        return theaters

    def get_movies_by_theater(self, cinema_name):
        _SQL = f"""
            SELECT movies.* from movies
            LEFT JOIN theater_movies
            ON movies.movieId = theater_movies.movieId
            LEFT JOIN theaters
            ON theater_movies.cinemaId = theaters.cinemaId
            WHERE theaters.cinemaName = '{cinema_name}'
        """
        self.cursor.execute(_SQL)
        movies = self.cursor.fetchall()
        return movies

    def add_tickets(self, tickets):
        date = datetime.strptime(tickets['date'], '%d/%m/%Y').strftime("%d/%m/%Y")
        _SQL = f"""
            INSERT INTO tickets (movieId, banner_image_url, movie_name, cinemaName, cinemaLocation, quantity, price, totalPrice, date, time, seat)
            VALUES ('{tickets['movieId']}', '{tickets['banner_image_url']}', '{tickets['movie_name']}', '{tickets['cinemaName']}', '{tickets['cinemaLocation']}', {int(tickets['quantity'])}, {int(tickets['price'])}, {int(tickets['totalPrice'])}, '{date}', '{tickets['time']}', '{tickets['seat']}');
        """
        self.cursor.execute(_SQL)
        self.conn.commit()

    def testes(self):
        _SQL = """
            SELECT * FROM movies
        """
        self.cursor.execute(_SQL)
        x = self.cursor.fetchall()[0]
        movie = {
            "about_movie": x[1],
            "banner_image_url": x[2],
            "cover_image_url": x[3],
            "languages": x[4],
            "movie_duration": x[5],
            "movie_name": x[6],
            "rating": x[7],
            "release_date": x[8],
        }
        print(movie)
