package com.ikhsan.a10120178_sensor;

/*
 * NIM  : 10120178
 *Nama  : Muhammad Noer Ikhsan Hidayat
 *Kelas : IF5
 *Email : muhammadnoerikhsanh@gmail.com
 * */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.ikhsan.a10120178_sensor.R;

public class viewpageradapter extends PagerAdapter {

    Context ctx;

    public viewpageradapter(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.viewpagerscreen, container, false);

        ImageView logo = view.findViewById(R.id.logo);
        ImageView dot1 = view.findViewById(R.id.dot1);
        ImageView dot2 = view.findViewById(R.id.dot2);

        TextView judul = view.findViewById(R.id.judul);
        TextView deskripsi = view.findViewById(R.id.deskripsi);

        Button selesai = view.findViewById(R.id.btn_selesai);


        switch (position) {
            case 0:
                logo.setImageResource(R.drawable.gambar1);
                dot1.setImageResource(R.drawable.dotselect);
                dot2.setImageResource(R.drawable.dotunselect);

                deskripsi.setText("Aplikasi ini dapat membantu Anda untuk menemukan rekomendasi tempat makan terdekat dari lokasi Anda. Geser untuk selanjutnya.");

                selesai.setVisibility(view.GONE);
                break;
            case 1:
                logo.setImageResource(R.drawable.gambar2);
                dot1.setImageResource(R.drawable.dotunselect);
                dot2.setImageResource(R.drawable.dotselect);

                judul.setText("Rekomendasi Kuliner");
                deskripsi.setText("Dijamin ada saja ide tempat kuliner untuk kamu coba! Selamat menjelajah :)");

                selesai.setVisibility(view.VISIBLE);

                break;

        }

        container.addView(view);
        return view;

    }
}
