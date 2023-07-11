package fr.amexio.ecm_as_a_service.service;

import fr.amexio.ecm_as_a_service.model.Container;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContainerService {

    private static List<Container> containers = new ArrayList<>();

    public List<Container> findAll(){
        return containers;
    }
    public void addContainer(Container container){
        containers.add(container);
    }
    public Container findById(int id){
        for (Container container : containers){
            if(container.getId() == id){
                return container;
            }
        }
        return null;
    }
    public Container deleteById(int id){
        Container container = findById(id);

        if(container == null){
            return null;
        }
        if(containers.remove(container)){
            return container;
        }
        return null;
    }

    public List<Container> findWaitingContainers(){
        List<Container> containerList = new ArrayList<>();
        for(Container container : containers){
            if(!container.isValide()){
                containerList.add(container);
            }
        }
        return containerList;
    }
}
