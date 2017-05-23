package com.example.t_gamer.compmovel;


import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.File;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddCursoFragment extends Fragment {


    public AddCursoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_curso, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        Button btnAddNewCurso = (Button) view.findViewById(R.id.btnAddNewCurso);

        btnAddNewCurso.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText mTitulo = (EditText) getView().findViewById(R.id.etAddCursoTitulo);
                EditText mDescricao = (EditText) getView().findViewById(R.id.mtAddCursoDescricao);
                TextView mErrorCont = (TextView) getView().findViewById(R.id.tvAddCursoErrorContainer);
                ProgressBar mProgressBar = (ProgressBar) getView().findViewById(R.id.pbAddCurso);
                ScrollView mContainer = (ScrollView) getView().findViewById(R.id.addCursoContainer);

                mContainer.setVisibility(View.GONE);
                mProgressBar.setVisibility(View.VISIBLE);

                String sErrorMessage = "";

                if(mTitulo.getText().toString().compareTo("") != 0){
                    if(mDescricao.getText().toString().compareTo("") != 0){
                        /** Aqui vai a função de registrar **/

                        /** se validado **/
                        String path = Environment.getDataDirectory().getAbsolutePath().toString() + "/storage/emulated/0/appFolder";
                        File mFolder = new File(path);
                        if (!mFolder.exists()) {
                            mFolder.mkdir();
                        }
                        File Directory = new File("/sdcard/Collecture/" + mTitulo.getText().toString()); //ou ID
                        Directory.mkdirs();

                        getActivity().getFragmentManager().popBackStack();

                    } else {
                        sErrorMessage = "Descrição Não pode estar vazia!";
                    }
                } else {
                    sErrorMessage = "Título não pode estar vazio!";
                }

                mProgressBar.setVisibility(View.GONE);
                mContainer.setVisibility(View.VISIBLE);

                mErrorCont.setText(sErrorMessage);
            }
        });
    }
}
