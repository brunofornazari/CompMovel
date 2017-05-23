package com.example.t_gamer.compmovel;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenu;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private NavigationView mNav;
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mNav = (NavigationView) findViewById(R.id.navigationMenu);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        mNav.setNavigationItemSelectedListener(this);

        String path = Environment.getDataDirectory().getAbsolutePath().toString() + "/storage/emulated/0/appFolder";
        File mFolder = new File(path);
        if (!mFolder.exists()) {
            mFolder.mkdir();
        }
        File Directory = new File("/sdcard/Collecture/");
        Directory.mkdirs();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        TextView headerNav = (TextView) findViewById(R.id.headerNav);
        Resources res = getResources();

        userName = "Mock"; // Colocar nome do usuário de verdade



        if(headerNav != null){
            headerNav.setText(String.format(res.getString(R.string.headernav), userName));
        }

        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        Fragment fragment = null;

        switch(id){
            case R.id.navCursos :
                fragment = new CursosFragment();
                break;
            case R.id.navAddCurso :
                fragment = new AddCursoFragment();
                break;
            default :

                break;
        }

        if(fragment != null){
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.addToBackStack(Integer.toString(id));
            fragmentTransaction.replace(R.id.mainFragment, fragment);
            fragmentTransaction.commit();
        }

        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed(){
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            new AlertDialog.Builder(this)
                    .setTitle("Really Exit?")
                    .setMessage("Are you sure you want to exit?")
                    .setNegativeButton(android.R.string.no, null)
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface arg0, int arg1) {
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            intent.putExtra("LOGOUT", true);
                            startActivity(intent);

                            finish();
                        }
                    }).create().show();
        }

    }
}
