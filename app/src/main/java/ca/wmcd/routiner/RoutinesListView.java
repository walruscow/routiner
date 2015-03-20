package ca.wmcd.routiner;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import java.util.List;

/**
 * Created by WalrusCow on 3/19/15.
 * List all routines.
 */
public class RoutinesListView extends RecyclerView {
    public RoutinesListView(Context context) {
        super(context);
        init();
    }

    public RoutinesListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RoutinesListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public RoutinesListView(Context context, AttributeSet attrs, int defStyleAttr,
                               int defStyleRes) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    public RoutinesListAdapter getAdapter() {
        return (RoutinesListAdapter) super.getAdapter();
    }

    private void init() {
        setLayoutManager(new LinearLayoutManager(getContext()));
        setAdapter(new RoutinesListAdapter());
        RoutineDatabase.getRoutines(getContext(), new RoutineDatabase.GetRoutinesCallback() {
            @Override
            public void call(List<Routine> routines) {
                RoutinesListAdapter adapter = getAdapter();
                adapter.routines = routines;
                adapter.notifyDataSetChanged();
            }
        });
    }
}
