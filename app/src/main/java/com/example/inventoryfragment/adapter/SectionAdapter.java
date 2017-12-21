package com.example.inventoryfragment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.inventoryfragment.R;
import com.example.inventoryfragment.data.db.model.Section;
import com.example.inventoryfragment.data.db.repo.SectionRepository;

import java.util.ArrayList;

/**
 * @author Elena G (Beelzenef)
 */

public class SectionAdapter extends RecyclerView.Adapter<SectionAdapter.SectionViewHolder> {

    private ArrayList<Section> sections;
    /** Array para almacenar sectores modificados en la interfaz y no se han guardado aún en base de datos
     * Repository en nuestro caso
    */
    private ArrayList<Section> sectionsModified;

    private OnSwitchCheckedChangeListener onSwitchCheckedChangeListener;

    /// OnClickRecyclerView
    private OnItemClickListener onItemClickListener;

    public SectionAdapter(OnItemClickListener listener)
    {
        sections = SectionRepository.getInstance().getSections();
        sectionsModified = new ArrayList<>();
        this.onItemClickListener = listener;
    }

    /**
     * Constructor que será llamado cuando SectorActivity venga de un cambio de configuracion
     * y tengamos que asegurar el estado dinánmico
     * @param sectionsModified
     */
    public SectionAdapter(ArrayList<Section> sectionsModified, OnItemClickListener listener)
    {
        sections = SectionRepository.getInstance().getSections();
        this.sectionsModified = sectionsModified;
        this.onItemClickListener = listener;
    }

    @Override
    public SectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflador = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflador.inflate(R.layout.item_section, null);
        SectionViewHolder sectionViewHolder =  new SectionViewHolder(view);
        return sectionViewHolder;
    }

    @Override
    public void onBindViewHolder(SectionViewHolder holder, int position) {
        holder.swEnabled.setChecked(sections.get(position).isEnabled());
        holder.swEnabled.setOnCheckedChangeListener(onSwitchCheckedChangeListener);
        holder.txtV_SectionName.setText(sections.get(position).getName());

        if (sections.get(position).isDefaultSection())
           holder.txtV_SectionShortName.setText(sections.get(position).getShortName());

        holder.bind(sections.get(position), onItemClickListener);
    }

    /**
     * Se crearán tantos elementos SectionViewHolder como elementos haya en el ArrayList definido dentro de la Clase
     * @return n sections
     */
    @Override
    public int getItemCount() {
        return sections.size();
    }


    public static class SectionViewHolder extends RecyclerView.ViewHolder {

        private Switch swEnabled;
        private TextView txtV_SectionName;
        private TextView txtV_SectionShortName;

        public SectionViewHolder(View itemView) {
            super(itemView);

            swEnabled = (Switch) itemView.findViewById(R.id.sw_Section);
            txtV_SectionName = (TextView) itemView.findViewById(R.id.txtV_NameSection);
            txtV_SectionShortName = (TextView) itemView.findViewById(R.id.txtV_ShortnameSection);
        }

        /// OnClickRecyclerView: asignando evento onClick
        public void bind(final Section s, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(s);
                }
            });
        }
    }

    /**
     *
     * @return Secciones modificados
     */
    public ArrayList<Section> getSectionsModified()
    {
        return sectionsModified;
    }

    class OnSwitchCheckedChangeListener implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            // Resolver estado dinámico
        }
    }


    /// OnClickRecyclerView: interfaz para gestionar clicks

    public interface OnItemClickListener {
        void onItemClick(Section s);
    }
}
