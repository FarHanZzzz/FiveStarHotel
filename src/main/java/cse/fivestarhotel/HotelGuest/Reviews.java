package cse.fivestarhotel.HotelGuest;

import java.io.Serializable;

public class Reviews implements Serializable {
    private String name, rating, review;

    public Reviews(String name, String rating, String review) {
        this.name = name;
        this.rating = rating;
        this.review = review;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "name='" + name + '\'' +
                ", rating='" + rating + '\'' +
                ", review='" + review + '\'' +
                '}';
    }
}