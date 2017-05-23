package com.example.t_gamer.compmovel;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.t_gamer.compmovel.classes.Curso;
import com.example.t_gamer.compmovel.classes.Materia;


/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment {

    int[] IMAGES = {R.drawable.logocollecture, R.drawable.logocollecture, R.drawable.logocollecture, R.drawable.logocollecture, R.drawable.logocollecture};
    Bundle instance;
    Curso oSelectedCurso;
    int iSelectedModule;
    Materia oSelectedClass;
    ListView lvGallery;

    public GalleryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        instance = savedInstanceState;
        oSelectedCurso = (Curso) getArguments().get("curso");
        iSelectedModule = (int) getArguments().get("modulo");
        oSelectedClass = (Materia) getArguments().get("materia");
        return inflater.inflate(R.layout.fragment_gallery, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        lvGallery = (ListView) view.findViewById(R.id.lvGallery);

        GalleryCustomAdapter customAdapter = new GalleryCustomAdapter();

        lvGallery.setAdapter(customAdapter);
    }

    class GalleryCustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater(instance).inflate(R.layout.gallery_adapter_layout, null);

            ImageView mImage = (ImageView) convertView.findViewById(R.id.ivGallery);

            mImage.setImageResource(IMAGES[position]);

            return convertView;
        }
    }

}
