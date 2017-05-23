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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.t_gamer.compmovel.classes.Curso;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class ModulosActivity extends Fragment {

    private int[] arrModules;
    Bundle instance;
    Curso oSelectedCurso;
    ListView lvModulos;

    public ModulosActivity() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        arrModules = new int[]{1, 2, 3, 4}; //Aqui vão os módulos
        instance = savedInstanceState;
        oSelectedCurso = (Curso) getArguments().get("curso");
        return inflater.inflate(R.layout.fragment_modulos, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        TextView mHeader = (TextView) view.findViewById(R.id.tvModulosHeader);
        lvModulos = (ListView) view.findViewById(R.id.lvModulos);
        ModulosCustomAdapter moduloAdapter = new ModulosCustomAdapter();
        FloatingActionButton btnNewModulo = (FloatingActionButton) view.findViewById(R.id.flbtnAddNewModulo);

        mHeader.setText(String.format(getResources().getString(R.string.headerModule), oSelectedCurso.getTitulo()));

        btnNewModulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /** Código para adicionar um novo módulo aqui  e recaregar o fragment com dados do banco **/
            }
        });

        lvModulos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                int moduloSelecionado = arrModules[position];
                bundle.putSerializable("curso", oSelectedCurso);
                bundle.putSerializable("modulo", moduloSelecionado);

                MateriasFragment fragment = new MateriasFragment();
                fragment.setArguments(bundle);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.addToBackStack(Integer.toString(oSelectedCurso.getId()) + "m" + Integer.toString(moduloSelecionado));
                transaction.replace(R.id.mainFragment, fragment).commit();
            }
        });

        lvModulos.setAdapter(moduloAdapter);
    }

    class ModulosCustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return arrModules.length;
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

            titulo.setText(Integer.toString(arrModules[position]) + "° Módulo");
            return convertView;
        }
    }

}
