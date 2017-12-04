package com.example.inventoryfragment.ui.dependency;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inventoryfragment.R;
import com.example.inventoryfragment.data.db.model.Dependency;
import com.example.inventoryfragment.ui.base.BaseFragment;
import com.example.inventoryfragment.ui.base.BasePresenter;
import com.example.inventoryfragment.ui.dependency.contract.AddEditDependencyContract;
import com.example.inventoryfragment.ui.dependency.presenter.AddEditDependencyPresenter;
import com.example.inventoryfragment.utils.AddEdit;

/**
 * Fragment, añadir/editar una dependencia
 */

public class AddEditDependency_Fragment extends BaseFragment implements AddEditDependencyContract.View {

    public static final String TAG = "addeditDependency";

    AddEditDependencyContract.Presenter presenter;

    FloatingActionButton fab_addDependency;
    TextInputEditText tID_DependencyName;
    TextInputEditText tID_DependencyShortname;
    TextInputEditText tID_DependencyDescription;

    private static boolean dependenciaModificada;
    private static int posicionAModificar;

    private static AddEdit mode;

    private static Dependency dependency;


    // Instancia de interfaz que interactuará con la Activity
    // Llamará al método que nos devuelve a la lista de dependencias
    AddNewDependencyClickListener callback;

    public static AddEditDependency_Fragment newInstance(Bundle args) {

        AddEditDependency_Fragment addeditDependency = new AddEditDependency_Fragment();

        mode = new AddEdit(AddEdit.ADD_MODE);

        if (args != null)
        {
            addeditDependency.setArguments(args);
            mode.setMode(AddEdit.EDIT_MODE);
            dependency = (Dependency) args.getParcelable(Dependency.TAG);
            posicionAModificar = args.getInt("posicion");
        }

        return addeditDependency;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dependencyaddedit_fragment, container, false);

        dependenciaModificada = false;

        // Como el fragment mantiene el estado ( y solo se elimina la vista) se debe reinicializar el presenter
        // cuando se crea la vista
        this.presenter = new AddEditDependencyPresenter(this);

        tID_DependencyDescription = (TextInputEditText) rootView.findViewById(R.id.edtDescription);
        tID_DependencyDescription.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tID_DependencyDescription.setError(null);
                dependenciaModificada = true;
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        tID_DependencyShortname = (TextInputEditText) rootView.findViewById(R.id.edtShortname);
        tID_DependencyShortname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tID_DependencyShortname.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        tID_DependencyName = (TextInputEditText) rootView.findViewById(R.id.edtName);
        tID_DependencyName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tID_DependencyName.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        fab_addDependency = (FloatingActionButton) rootView.findViewById(R.id.fab_dependency);
        fab_addDependency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.validateDependency(tID_DependencyName.getText().toString(),
                                                tID_DependencyShortname.getText().toString(),
                                                    tID_DependencyDescription.getText().toString());
            }
        });

        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (AddEditDependencyContract.Presenter) presenter;
    }

    @Override
    public void setNameError() {
        tID_DependencyName.setError("Nombre de dependencia vacío");
    }

    @Override
    public void setDescError() {
        tID_DependencyDescription.setError("Descripcion vacía");
    }

    @Override
    public void setShortnameError() {
        tID_DependencyShortname.setError("Nombre corto vacío");

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (mode.getMode() == AddEdit.EDIT_MODE)
        {
            tID_DependencyShortname.setText(dependency.getShortname());
            tID_DependencyShortname.setEnabled(false);
            tID_DependencyDescription.setText(dependency.getDescription());
            tID_DependencyName.setText(dependency.getName());
            tID_DependencyName.setEnabled(false);
        }
    }

    // Si to-do es correcto, volvemos para mostrar la lista de dependencias
    // con la nueva dependencia añadida
    @Override
    public void addingCorrectDependency() {

        /* TODO Delegar a Presenter -> Interactor
        Dependency newDep = new Dependency(0, tID_DependencyName.getText().toString(),
                tID_DependencyShortname.getText().toString(),
                tID_DependencyDescription.getText().toString());

        DependencyRepository.getInstance().addDependency(newDep);
        */

        /*
        if (dependenciaModificada)
        {
            // Eliminar posicion
            DependencyRepository.getInstance().getDependencies().remove(posicionAModificar);
        }
        */

        if (mode.getMode() == AddEdit.EDIT_MODE)
        {
            dependency = new Dependency(0, tID_DependencyName.getText().toString(),
                    tID_DependencyShortname.getText().toString(),
                    tID_DependencyDescription.getText().toString());
            presenter.editDependency(dependency);
        }

        if (mode.getMode() == AddEdit.ADD_MODE) {
            presenter.addNewDependency(tID_DependencyName.getText().toString(),
                    tID_DependencyShortname.getText().toString(),
                    tID_DependencyDescription.getText().toString());
        }

        callback.returnToDependencyList();
    }

    /**
     *
     * Si no está implementada la interfaz, saltará excepción
     */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            callback = (AddNewDependencyClickListener) activity;
        } catch (ClassCastException e)
        {
            throw new ClassCastException(getActivity().getLocalClassName() + "must be implemented");
        }
    }

    interface AddNewDependencyClickListener
    {
        void addingNewDependency(Dependency d);
        void updateDependency(Dependency d);
        void returnToDependencyList();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
