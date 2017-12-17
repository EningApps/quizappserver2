package com.quizapp.quiz;

import com.quizapp.quiz.quizentity.EntityController;
import com.quizapp.quiz.quizentity.QuizEntity;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@EnableJpaAuditing
@SpringBootApplication
public class QuizApplication {

	private static final String URLadress="https://quizappby.herokuapp.com/api/entities";
	private static final String ANSWERS="2t10m bkg1 chme3 dr1p drb1 epg epr er9t ten60 vl80";

	public static void main(String[] args) {

		SpringApplication.run(QuizApplication.class, args);

		DBInitializer dbInitializer=new DBInitializer();
		dbInitializer.initializeDb("https://firebasestorage.googleapis.com/v0/b/trains-8c97a.appspot.com/o/2t10m.jpg?alt=media&token=5b0a1ee3-2e5e-446d-b51f-795c2821ca2b",ANSWERS,"2t10m");
		dbInitializer.initializeDb("https://firebasestorage.googleapis.com/v0/b/trains-8c97a.appspot.com/o/bkg1.jpg?alt=media&token=f7ec8b26-69a6-41df-a8d0-174f688b629f",ANSWERS,"bkg1");
		dbInitializer.initializeDb("https://firebasestorage.googleapis.com/v0/b/trains-8c97a.appspot.com/o/chme3.jpg?alt=media&token=54540888-915c-485b-bf91-7ded03c62c96",ANSWERS,"chme3");
		dbInitializer.initializeDb("https://firebasestorage.googleapis.com/v0/b/trains-8c97a.appspot.com/o/dr1p.jpg?alt=media&token=36133c1c-fb20-4e6d-bdf2-8ea17915123b",ANSWERS,"dr1p");
		dbInitializer.initializeDb("https://firebasestorage.googleapis.com/v0/b/trains-8c97a.appspot.com/o/drb1.jpg?alt=media&token=4326d0bd-00fc-4c75-a2a8-ba09fe43d891",ANSWERS,"drb1");
		dbInitializer.initializeDb("https://firebasestorage.googleapis.com/v0/b/trains-8c97a.appspot.com/o/epg.jpg?alt=media&token=35c0a669-4b4e-4c9d-b038-7a42d576fa7a",ANSWERS,"epg");
		dbInitializer.initializeDb("https://firebasestorage.googleapis.com/v0/b/trains-8c97a.appspot.com/o/epr.jpg?alt=media&token=93ed5783-da8f-4279-aa7f-66773a711326",ANSWERS,"epr");
		dbInitializer.initializeDb("https://firebasestorage.googleapis.com/v0/b/trains-8c97a.appspot.com/o/er9t.jpg?alt=media&token=3ac6c054-5a25-4549-ab42-8f7dc3c696bb",ANSWERS,"er9t");
		dbInitializer.initializeDb("https://firebasestorage.googleapis.com/v0/b/trains-8c97a.appspot.com/o/ten60.jpg?alt=media&token=8d62f256-7041-457c-aca7-0a122fb79ccd",ANSWERS,"ten60");
		dbInitializer.initializeDb("https://firebasestorage.googleapis.com/v0/b/trains-8c97a.appspot.com/o/vl80.jpg?alt=media&token=80642204-0b7b-45a2-9f6c-ea65670f3636",ANSWERS,"vl80");

	}

	private static class DBInitializer{

		 void initializeDb(String picUrl, String allAnswers, String correctAnswer){
			URL url;
			HttpURLConnection urlConnection = null;
			try {
				url = new URL(URLadress);
				urlConnection = (HttpURLConnection) url.openConnection();
				urlConnection.setDoOutput(true);
				urlConnection.setDoInput(true);
				urlConnection.setRequestMethod("POST");
				urlConnection.setRequestProperty("Content-Type", "application/json");
				DataOutputStream wr = new DataOutputStream(urlConnection.getOutputStream());
				try {
					JSONObject obj = new JSONObject();
					obj.put("picUrl", picUrl);
					obj.put("correctAnswer", correctAnswer);
					obj.put("allAnswers", allAnswers);
					wr.writeBytes(obj.toString());
					wr.flush();
					wr.close();
				} catch (JSONException ex) {
					ex.printStackTrace();
				}
				urlConnection.connect();
				int response=urlConnection.getResponseCode();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
