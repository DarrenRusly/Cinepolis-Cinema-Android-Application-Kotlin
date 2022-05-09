from flask import Flask, request, jsonify
from flask_cors import CORS
from db import DB
import json

from datetime import date

app = Flask(__name__)
CORS(app)
@app.route("/get-movies", methods=["GET"])
def getMovies():
    db = DB()
    movies = db.get_movies()
    data = {"movies": []}
    for x in movies:
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
        data['movies'].append(movie)
    db.conn.close()
    return jsonify(data)

@app.route("/select-theater", methods=["GET", "POST"])
def selectTheater():
    data = request.get_json()
    movieId = data['movieId']
    db = DB()
    theaters = db.get_theater_from_movieId(movieId)
    send_data = {"theaters": []}
    for x in theaters:
        theater = {
            "cinemaName": x[0],
            "cinemaLocation": x[1],
            "cinemaDrawable": x[2]
        }
        send_data['theaters'].append(theater)
    db.conn.close()
    return jsonify(send_data)

@app.route("/get-theater-movies", methods=["GET", "POST"])
def getTheaterMovies():
    data = request.get_json()
    movie_title = data['movie_name']
    db = DB()
    movies = db.get_movies_by_theater(movie_title)
    print(len(movies))
    send_data = {"movies": []}
    for x in movies:
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
        send_data['movies'].append(movie)
    db.conn.close()
    return jsonify(send_data)

@app.route("/get-theaters", methods=["GET", "POST"])
def getTheaters():
    db = DB()
    theaters = db.get_theaters()
    send_data = {"theaters": []}
    for x in theaters:
        theater = {
            "cinemaName": x[0],
            "cinemaLocation": x[1],
            "cinemaDrawable": x[2]
        }
        send_data['theaters'].append(theater)
    db.conn.close()
    return jsonify(send_data)

@app.route("/get-orders", methods=["GET"])
def getOrders():
    today = date.today().strftime("%d/%m/%Y")
    db = DB()
    orders = db.get_orders(today)
    send_data = {"orders": orders}
    print(send_data)
    db.conn.close()
    return jsonify(send_data)

@app.route("/check-seats", methods=["POST"])
def check_seats():
    data = request.get_json()
    print(data)
    db = DB()
    tickets = db.get_tickets(data['movieId'], data['cinemaName'], data['date'], data['time'])
    print(tickets)
    send_data = {"tickets": tickets}
    db.conn.close()
    return jsonify(send_data)

@app.route("/checkout", methods=["POST"])
def checkout():
    data = request.get_json()
    print(data)
    db = DB()
    db.add_tickets(data)
    db.conn.close()
    return jsonify(data)

app.run(host="0.0.0.0", threaded=True)