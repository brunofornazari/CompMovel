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
import android.widget.Toast;

import com.example.t_gamer.compmovel.classes.Curso;


/**
 * A simple {@link Fragment} subclass.
 */
public class CursosFragment extends Fragment {

    private Curso[] arrCursos;
    ListView lvCursos;
    Bundle instance = null;


    public CursosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        instance = savedInstanceState;

        arrCursos = new Curso[]{
                new Curso(1, "Curso 1", "Este é o curso 1"),
                new Curso(2, "Curso 2", "Este é o curso 2"),
                new Curso(3, "Curso 3", "Este é o curso 3")
        };

        return inflater.inflate(R.layout.fragment_cursos, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState){
        lvCursos = (ListView) view.findViewById(R.id.lvCursos);
        CursosCustomAdapter cursoAdapter = new CursosCustomAdapter();
        FloatingActionButton btnNewCurso = (FloatingActionButton) view.findViewById(R.id.flbtnAddNewCurso);

        btnNewCurso.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                Fragment  fragment = new AddCursoFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction =  getFragmentManager().beginTransaction();
                fragmentTransaction.addToBackStack("Cursos");
                fragmentTransaction.replace(R.id.mainFragment, fragment);
                fragmentTransaction.commit();

                v.setVisibility(View.GONE);
            }
        });

        lvCursos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                Curso cursoSelecionado = arrCursos[position];
                bundle.putSerializable("curso", cursoSelecionado);

                ModulosActivity fragment = new ModulosActivity();
                fragment.setArguments(bundle);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.addToBackStack(Integer.toString((cursoSelecionado.getId())));
                transaction.replace(R.id.mainFragment, fragment).commit();
            }
        });

        lvCursos.setAdapter(cursoAdapter);
    }

    class CursosCustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return arrCursos.length;
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

            titulo.setText(arrCursos[position].getTitulo());
            return convertView;
        }
    }

}
