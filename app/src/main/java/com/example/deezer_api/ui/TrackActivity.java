package com.example.deezer_api.ui;
//
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//
//
//
//import com.example.deezer_api.R;
//import com.example.deezer_api.control.TrackController;
//import com.example.deezer_api.model.Track;
//
public class TrackActivity extends AppCompatActivity {
//
//    private Track track;
//    private TrackController controller;
//    private ImageView image;
//    private TextView nameTV, artistTV, albumTV, durationTV;
//    private Button playBtn;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_track);
//
//        track = (Track) getIntent().getExtras().getSerializable("track");
//
//        this.image =  findViewById(R.id.image);
//        this.nameTV =  findViewById(R.id.nameTV);
//        this.artistTV =  findViewById(R.id.artistTV);
//        this.albumTV =  findViewById(R.id.albumTV);
//        this.durationTV =  findViewById(R.id.durationTV);
//        this.playBtn = findViewById(R.id.playBtn);
//
//        this.controller = new TrackController(this);
//    }
//
//    public Track getTrack() {
//        return track;
//    }
//
//    public ImageView getImage() {
//        return image;
//    }
//
//    public void setImage(ImageView image) {
//        this.image = image;
//    }
//
//    public TextView getNameTV() {
//        return nameTV;
//    }
//
//    public void setNameTV(TextView nameTV) {
//        this.nameTV = nameTV;
//    }
//
//    public TextView getArtistTV() {
//        return artistTV;
//    }
//
//    public void setArtistTV(TextView artistTV) {
//        this.artistTV = artistTV;
//    }
//
//    public TextView getAlbumTV() {
//        return albumTV;
//    }
//
//    public void setAlbumTV(TextView albumTV) {
//        this.albumTV = albumTV;
//    }
//
//    public TextView getDurationTV() {
//        return durationTV;
//    }
//
//    public void setDurationTV(TextView durationTV) {
//        this.durationTV = durationTV;
//    }
//
//    public Button getPlayBtn() {
//        return playBtn;
//    }
//
//    public void setPlayBtn(Button playBtn) {
//        this.playBtn = playBtn;
//    }
}
