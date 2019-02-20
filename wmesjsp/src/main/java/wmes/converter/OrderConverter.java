package wmes.converter;
import wmes.dto.ClientDTO;
import wmes.dto.OrderDTO;
import wmes.dto.UserDTO;
import wmes.model.Client;
import wmes.model.Order;
import wmes.model.User;

/**
 * Il converter si occupa di "convertire" un model in un dto e viceversa
 *
 */
public class OrderConverter {


	/**
	 * Converte un OrderDTO in Order
	 */
	public static Order toEntity(OrderDTO orderDTO) {

		Order order = null;
		if (orderDTO != null) {
			User user = UserConverter.toEntity(orderDTO.getUserDTO());
			Client client = ClientConverter.toEntity(orderDTO.getClientDTO());
			order = new Order(user, client, orderDTO.getDescription());
			order.setOrderId(orderDTO.getId());
		}

		return order;
	}

	/**
	 * Converte un Order in OrderDTO
	 */

	public static OrderDTO toDTO(Order order) {

		OrderDTO orderDTO  = null;
		if (order != null) {
			UserDTO userDTO = UserConverter.toDTO(order.getUser());
			ClientDTO clientDTO=ClientConverter.toDTO(order.getClient());
			orderDTO = new OrderDTO(userDTO,clientDTO, order.getDescription());
			orderDTO.setId(order.getOrderId());
		}

		return orderDTO;
	}
	

}