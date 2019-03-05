package it.contrader.wmesspring.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.wmesspring.dto.ResourceDTO;
import it.contrader.wmesspring.model.Resource;

public class ConverterResource {

	public static ResourceDTO toDTO(Resource resource) {
		ResourceDTO resourceDTO = null;
		if (resource != null) {
			resourceDTO = new ResourceDTO();

			resourceDTO.setResourceId(resource.getResourceId());
			resourceDTO.setUserDTO(ConverterUser.toDTO(resource.getUser()));
			resourceDTO.setResourceUsername(resource.getResourceUsername());
			resourceDTO.setResourcePass(resource.getResourcePass());
			resourceDTO.setResourceName(resource.getResourceName());

		}
		return resourceDTO;
	}

	public static Resource toEntity(ResourceDTO resourceDTO) {
		Resource resource = null;
		if (resourceDTO != null) {
			resource = new Resource();
			resource.setResourceId(resourceDTO.getResourceId());
			resource.setUser(ConverterUser.toEntity(resourceDTO.getUserDTO()));
			resource.setResourceUsername(resourceDTO.getResourceUsername());
			resource.setResourcePass(resourceDTO.getResourcePass());
			resource.setResourceName(resourceDTO.getResourceName());
		}
		return resource;
	}

	public static List<ResourceDTO> toListDTO(List<Resource> list) {
		List<ResourceDTO> listResourceDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Resource resource : list) {
				listResourceDTO.add(ConverterResource.toDTO(resource));
			}
		}
		return listResourceDTO;
	}

	public static List<Resource> toListEntity(List<ResourceDTO> listResourceDTO) {
		List<Resource> list = new ArrayList<>();
		if (!listResourceDTO.isEmpty()) {
			for (ResourceDTO resourceDTO : listResourceDTO) {
				list.add(ConverterResource.toEntity(resourceDTO));
			}
		}
		return list;
	}

}
