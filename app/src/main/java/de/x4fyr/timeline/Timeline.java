package de.x4fyr.timeline;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import dagger.Component;
import de.x4fyr.timeline.adapter.ModelAdapter;
import de.x4fyr.timeline.model.Model;
import de.x4fyr.timeline.model.ModelModule;
import lombok.Getter;

import javax.inject.Singleton;
import java.sql.Time;
import java.util.Optional;

/**
 * Main activity.
 */

public class Timeline extends AppCompatActivity {

    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timeline.context = getApplicationContext();
        setContentView(R.layout.activity_timeline);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //AdapterComponents component = DaggerTimeline_AdapterComponents.builder().modelModule(new ModelModule(false/*TODO: Set by setting*/)).build();
        //ModelAdapter modelAdapter = component.modelAdapter();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_timeline, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static Optional<Context> getContext() {
        return Optional.ofNullable(Timeline.context);
    }

    //@Component(modules = ModelModule.class)
    //@Singleton
    //interface AdapterComponents {
    //    ModelAdapter modelAdapter();
    //}
}