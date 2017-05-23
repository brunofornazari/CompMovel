package com.example.t_gamer.compmovel;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.t_gamer.compmovel.classes.Curso;
import com.example.t_gamer.compmovel.classes.Materia;

/**
 * A simple {@link Fragment} subclass.
 */
public class MateriasFragment extends Fragment {

    Materia[] arrMaterias;
    Bundle instance;
    Curso oSelectedCurso;
    int iSelectedModule;
    ListView lvMaterias;

    public MateriasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        arrMaterias = new Materia[]{
                new Materia(1, "Computação Móvel", "Tá tenso? Tá tenso."),
                new Materia(2, "Princípios de Comunicação", "Cilada na certa"),
                new Materia(3, "Redes de Computadores", "Uma das melhores do semestre"),
                new Materia(4, "Sistemas Embarcados", "As asulas são uma droga? Comigo vai ser diferente. SQN"),
                new Materia(5, "Sistemas Distribuídos", "Ainda não consigo olhar na cara do kakugawa por não ter entregue o projeto dele")
        }; // Aqui vão as matérias
        instance = savedInstanceState;
        oSelectedCurso = (Curso) getArguments().get("curso");
        iSelectedModule = (int) getArguments().get("modulo");

        return inflater.inflate(R.layout.fragment_materias, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        TextView mHeader = (TextView) view.findViewById(R.id.tvMateriasHeader);
        TextView mSubHeader = (TextView) view.findViewById(R.id.tvMateriasSubheader);
        lvMaterias = (ListView) view.findViewById(R.id.lvMaterias);
        MateriasCustomAdapter materiaAdapter = new MateriasCustomAdapter();
        FloatingActionButton btnNewMateria = (FloatingActionButton) view.findViewById(R.id.flbtnAddNewMateria);

        mHeader.setText(String.format(getResources().getString(R.string.classesHeader), oSelectedCurso.getTitulo()));
        mSubHeader.setText(String.format(getResources().getString(R.string.classesSubheader), iSelectedModule));

        lvMaterias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                Materia materiaSelecionada = arrMaterias[position];
                bundle.putSerializable("curso", oSelectedCurso);
                bundle.putSerializable("modulo", iSelectedModule);
                bundle.putSerializable("materia", materiaSelecionada);

                GalleryFragment fragment = new GalleryFragment();
                fragment.setArguments(bundle);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.addToBackStack(Integer.toString(oSelectedCurso.getId()) + "m" + Integer.toString(iSelectedModule) + "m" + materiaSelecionada.getTitulo());
                transaction.replace(R.id.mainFragment, fragment).commit();
            }
        });

        btnNewMateria.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("curso", oSelectedCurso);
                bundle.putSerializable("modulo", iSelectedModule);

                Fragment  fragment = new AddMateriaFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction =  getFragmentManager().beginTransaction();
                fragmentTransaction.addToBackStack("Materias");
                fragmentTransaction.replace(R.id.mainFragment, fragment);
                fragmentTransaction.commit();

                v.setVisibility(View.GONE);
            }
        });

        lvMaterias.setAdapter(materiaAdapter);
    }

    class MateriasCustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return arrMaterias.length;
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
            convertView = getLayoutInflater(instance).inflate(R.layout.cursos_adapter_layout, null);

            TextView titulo = (TextView) convertView.findViewById(R.id.tvCursoAdapter);

            titulo.setText(arrMaterias[position].getTitulo());
            return convertView;
        }
    }

}
