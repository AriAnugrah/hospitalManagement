package com.enigma.ari.tryThymeleaf.controllers;

import com.enigma.ari.tryThymeleaf.dao.RoomDao;
import com.enigma.ari.tryThymeleaf.entities.Rooms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RoomController {

    @Autowired
    private RoomDao dao;

    @RequestMapping("/room_table")
    public String viewHomePage(Model model) {
        List<Rooms> listRooms = dao.list();
        model.addAttribute("listRooms", listRooms);
        return "room_table";
    }

    @RequestMapping("/new_room")
    public String showNewForm(Model model) {
        Rooms rooms = new Rooms();
        model.addAttribute("rooms", rooms);

        return "new_form_room";
    }

    @RequestMapping(value = "/save_room", method = RequestMethod.POST)
    public String save(@ModelAttribute("rooms") Rooms rooms) {
        dao.save(rooms);

        return "redirect:/room_table";
    }

    @RequestMapping("/edit_room/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_form_room");
        Rooms rooms = dao.get(id);
        mav.addObject("rooms", rooms);

        return mav;
    }

    @RequestMapping(value = "/update_room", method = RequestMethod.POST)
    public String update(@ModelAttribute("rooms") Rooms rooms) {
        dao.update(rooms);

        return "redirect:/room_table";
    }

    @RequestMapping("/delete_room/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        dao.delete(id);
        return "redirect:/room_table";
    }
}
