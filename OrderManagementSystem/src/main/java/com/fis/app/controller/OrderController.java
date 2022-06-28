package com.fis.app.controller;

import com.fis.app.core.Result;
import com.fis.app.dto.*;
import com.fis.app.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
public class OrderController {

    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public Result<List<OrderDTO>> findAll() {
        try {
            List<OrderDTO> orderDTOList = orderService.findAll();
            return Result.success(orderDTOList);
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }

    }

    @GetMapping(params = { "page", "size" })
    public Result<OrderPaginationDTO> findAll(@RequestParam("page") int page,
                                              @RequestParam("size") int size) {
        try {
            OrderPaginationDTO result = orderService.findAll(page, size);
            return Result.success(result);
        } catch (Exception ex) {
            return Result.error(ex.getMessage());
        }

    }

    @PutMapping
    public Result<OrderDTO> create(@RequestBody OrderDTO orderDTO) {
        try {
            OrderDTO result = orderService.created(orderDTO);
            return Result.success(result);
        } catch (Exception ex) {
            return Result.error(ex.getMessage());
        }

    }

    @PostMapping("/addOrderItem")
    public Result<OrderDTO> addOrderItem(@RequestBody OrderItemDTO orderItemDTO) {
        try {
            OrderDTO result = orderService.addOrderItem(orderItemDTO);
            return Result.success(result);
        } catch (Exception ex) {
            return Result.error(ex.getMessage());
        }

    }

    @PostMapping("/removeOrderItem")
    public Result<OrderDTO> removeOrderItem(@RequestBody OrderRequestDTO orderRequestDTO) {
        try {
            OrderDTO result = orderService.removeOrderItem(orderRequestDTO);
            return Result.success(result);
        } catch (Exception ex) {
            return Result.error(ex.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    public Result<Object> delete(@PathVariable Long id) {
        try {
            orderService.delete(id);
            return Result.success("Xóa thành công order id: " + id);
        } catch (Exception ex) {
            return Result.error(ex.getMessage());
        }

    }

    @PostMapping("/cancel/{id}")
    public Result<Object> cancelOrder(@PathVariable Long id) {
        try {
            OrderDTO result = orderService.cancelOrder(id);
            return Result.success(result, "Hủy thành công order id: " + id);
        } catch (Exception ex) {
            return Result.error(ex.getMessage());
        }

    }

    @PostMapping("/paid/{id}")
    public Result<Object> paidOrder(@PathVariable Long id) {
        try {
            OrderDTO result = orderService.paidOrder(id);
            return Result.success(result, "Paid(or st what ever is it) thành công order id: " + id);
        } catch (Exception ex) {
            return Result.error(ex.getMessage());
        }

    }

}
