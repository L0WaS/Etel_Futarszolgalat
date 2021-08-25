package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.entity.AbstractEntity;
import hu.ulyssys.java.course.maven.service.CoreService;
import org.primefaces.PrimeFaces;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public abstract class CoreCRUDMbean<T extends AbstractEntity> implements Serializable {
    protected List<T> list;
    protected T selectedEntity;

    protected CoreService<T> service;

    public CoreCRUDMbean(CoreService<T> service) {
        this.service = service;
        setSelectedEntity(initNewEntity());
        setList(service.getAll());
    }

    public void initSave() {
        selectedEntity = initNewEntity();
    }

    public void save() {
        try {
            if (selectedEntity.getId() == null) {
                saveNewEntity();
            } else {
                updateEntity();
            }
            PrimeFaces.current().executeScript("PF('" + dialogName() + "').hide()");
        }catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sikertelen mentés/módosítás", null));
        }
    }

    protected void saveNewEntity(){
        selectedEntity.setCreatedDate(getCurrentDate());
        service.add(selectedEntity);
        refreshData();
        selectedEntity = initNewEntity();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres mentés"));
    }

    protected void refreshData(){
        setList(service.getAll());
    }

    protected void updateEntity(){
        service.update(selectedEntity);
        refreshData();
        selectedEntity = initNewEntity();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres módosítás"));
    }

    protected Date getCurrentDate(){
        Date date = new Date(System.currentTimeMillis());
        return date;
    }


    public void remove() {
        try {
            service.remove(selectedEntity);
            refreshData();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres törlés"));
        }catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sikertelen törlés", null));
        }
    }

    protected abstract String dialogName();

    protected abstract T initNewEntity();

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public T getSelectedEntity() {
        return selectedEntity;
    }

    public void setSelectedEntity(T selectedEntity) {
        this.selectedEntity = selectedEntity;
    }
}