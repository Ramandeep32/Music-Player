package com.raman.musicplayer

import android.app.Activity
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.media.AudioManager

import android.media.MediaPlayer





// FirebaseRecyclerAdapter is a class provided by
// FirebaseUI. it provides functions to bind, adapt and show
// database contents in a Recycler View
class SongAdapter(val context: Activity, val list:ArrayList<Song>): ArrayAdapter<Song>(context,R.layout.items_layout,list){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view=LayoutInflater.from(context).inflate(R.layout.items_layout,null)
        val songname:TextView;
        val songtag:TextView;
        val image:ImageView;
        val playbtn:Button;
        val pausebtn:Button;
        image = view.findViewById(R.id.song_image)
        songname=view.findViewById(R.id.song_name)
//        songtag=view.findViewById(R.id.)
        playbtn=view.findViewById<Button>(R.id.playsong)
        pausebtn=view.findViewById<Button>(R.id.pausesong)
        playbtn.setTag(list[position].songtag)
        pausebtn.setTag(list[position].songtag)
        songname.text=list[position].songname
        image.setImageResource(list[position].songimage)
        val mp3: Uri = Uri.parse(
            ("android.resource://"
                    + context.packageName + "/raw/"
                    +playbtn.getTag())
        )
        val mediaplayer = MediaPlayer.create(context,mp3)
        playbtn.setOnClickListener {

//            val parentRow = view.getParent() as View
//            val listView: ListView = parentRow.parent as ListView
//            val position: Int = listView.getPositionForView(parentRow)
//            val mp3: Uri = Uri.parse(
//                ("android.resource://"
//                        + context.packageName + "/raw/"
//                        +playbtn.getTag())
//            )
//            val mediaplayer = MediaPlayer.create(context,mp3)
//           lateinit var mediaPlayer : MediaPlayer
//            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)
//            mediaPlayer.setDataSource(context, mp3)
//            mediaPlayer.prepare() // might take long! (for buffering, etc)
//            mediaplayer.prepare()
            mediaplayer.start()

            playbtn.setText("Playing")

        }
        pausebtn.setOnClickListener{
//            val mp3: Uri = Uri.parse(
//                ("android.resource://"
//                        + context.packageName + "/raw/"
//                        +pausebtn.getTag())
//            )
//            val mediaplayer = MediaPlayer.create(context,mp3)
            if(mediaplayer.isPlaying)
            {
                mediaplayer.stop()
                playbtn.setText("Play")
            }

        }
        mediaplayer.setOnCompletionListener(object : MediaPlayer.OnCompletionListener {
            override fun onCompletion(mp: MediaPlayer?) {
                try {
                    mediaplayer!!.start()

                    mediaplayer!!.isLooping = true
                } catch (e: Exception) {
                    Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show()
                }
            }

        })
        return view
    }
}