package com.example.practise.base;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.RequestOptions;
public class BindingAdapter {

    @android.databinding.BindingAdapter("android:src")
    public static void loadBitmap(ImageView imageView, Bitmap url){
        Glide.with(imageView.getContext())
                .asBitmap()
                .load(url)
                .apply(
                        new RequestOptions().override(
                                300,
                                300
                        ).downsample(DownsampleStrategy.CENTER_INSIDE).skipMemoryCache(true).diskCacheStrategy(
                                DiskCacheStrategy.NONE
                        )
                )
                .into(imageView);
    }
    @android.databinding.BindingAdapter("android:src")
    public static void loadurl(ImageView imageView, String url){
        Glide.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }

    @android.databinding.BindingAdapter("initVideo")
    public static void initVideo(VideoView videoView, String url){
        MediaController mediaController=new MediaController(videoView.getContext(),false);
        mediaController.setEnabled(true);
        mediaController.show();
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.requestFocus();
        videoView.setVideoPath(url);
    }
}
