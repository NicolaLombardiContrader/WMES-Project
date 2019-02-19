package wmes.converter;
import wmes.dto.OrderDTO;
import wmes.model.Order;

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
			order = new Order(orderDTO.getUser(), orderDTO.getClient(), orderDTO.getDescription());
			//order.setOrderId(orderDTO.getId());
		}

		return order;
	}

	/**
	 * Converte un Order in OrderDTO
	 */

	public static OrderDTO toDTO(Order order) {

		OrderDTO orderDTO  = null;
		if (order != null) {
			orderDTO = new OrderDTO(order.getOrderId(), order.getUser(), order.getClient(), order.getDescription());
			//orderDTO.setId(order.getOrderId());
		}

		return orderDTO;
	}
	

}