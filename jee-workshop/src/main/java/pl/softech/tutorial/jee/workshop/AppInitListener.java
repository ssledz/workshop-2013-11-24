/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.softech.tutorial.jee.workshop;

import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Web application lifecycle listener.
 *
 * @author ssledz
 */
@WebListener
public class AppInitListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        User user = new User();
        user.setFirstName("Kazik");
        user.setLastName("Kowalski");
        user.setEmail("kazik.kowalski@sof-tech.pl");
        user.setUserName("root");
        user.setPassword("root");
        
        List<User> users = (List<User>) sce.getServletContext().getAttribute("users");
        if (users == null) {
            users = new LinkedList<>();
            sce.getServletContext().setAttribute("users", users);
        }

        users.add(user);
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
