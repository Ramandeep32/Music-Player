package com.raman.musicplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {



     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        val item=ArrayList<Song>()
        item.add(Song(R.drawable.arcade_image,"Arcade","arcade"))
        item.add(Song(R.drawable.into_your_arm,"Into your arms","into_your_arm"))
        item.add(Song(R.drawable.love_your_voice, "Love your voice","love_your_voice"))
        item.add(Song(R.drawable.na_ja, "Na ja","na_ja"))
        item.add(Song(R.drawable.get_ready_to_fight,"Get ready to fight","music_four"))
        item.add(Song(R.drawable.marjaban,"Tum hi ana","tum_hi_ana"))
        item.add(Song(R.drawable.bekhayali, "Bekhayali,","bekhayali"))
        item.add(Song(R.drawable.coca_cola_tu, "Coca cola tu","coca_cola"))
        item.add(Song(R.drawable.dil_mein_ho_tum,"Dil me ho tum ","dil_me_ho_tum"))
        item.add(Song(R.drawable.love_me_like,"Love me like you","love_me_like_you"))
//        item.add(Song(R.drawable.milne_h_mujhse_ay, "Milne h mujhse aayi","milne_h_mujhse_aayi"))
        item.add(Song(R.drawable.suno_na_sang, "Suno na sangmarmar","sunona_sangg_mar"))
        item.add(Song(R.drawable.tu_lang_mein, "Tu laung mein ilachi","tu_laung_main"))
        item.add(Song(R.drawable.tujhe_kitna_chahne, "Tujhe kitna chahne lge hum","tujhe_kitna_chahne"))
        item.add(Song(R.drawable.tum_hi_ho, "Tum hi ho","tum_hi_ho"))
        val adapter = SongAdapter(this,item)
        val recycler_view = findViewById<ListView>(R.id.list_view)
        recycler_view.adapter = adapter


    }

}