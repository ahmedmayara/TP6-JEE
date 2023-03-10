package com.ahmed.tp6.web;

import com.ahmed.tp6.dao.CategorieDao;
import com.ahmed.tp6.dao.CategorieDaoImpl;
import entities.Categorie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "CategorieServlet", urlPatterns = {"/categories", "/saisieCategorie", "/saveCategorie", "/supprimerCategorie", "/editerCategorie", "/updateCategorie"})
public class CategorieServlet extends HttpServlet {
    CategorieDao metier;

    @Override
    public void init() throws ServletException {
        metier = new CategorieDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();

        if (path.equals("/categories")) {
            CategorieModele model = new CategorieModele();
            List<Categorie> categories = metier.getAllCategories();
            model.setCategories(categories);
            request.setAttribute("model", model);
            request.getRequestDispatcher("categories.jsp").forward(request, response);
        }
        else if (path.equals("/saisieCategorie")) {
            request.getRequestDispatcher("saisieCategorie.jsp").forward(request, response);
        }
        else if (path.equals("/saveCategorie") && request.getMethod().equals("POST")) {
            Date dateCreation = new Date();
            String nom = request.getParameter("nom");
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            try {
                dateCreation = simpleDateFormat.parse(request.getParameter("dateCreation"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            Categorie categorie = metier.save(new Categorie(nom, dateCreation));
            request.setAttribute("categorie", categorie);
            response.sendRedirect("categories");
        }
        else if (path.equals("/supprimerCategorie")) {
            int id = Integer.parseInt(request.getParameter("id"));
            metier.deleteCategorie(id);
            response.sendRedirect("categories");
        }
        else if (path.equals("/editerCategorie")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Categorie c = metier.getCategorie(id);
            request.setAttribute("categorie", c);
            request.getRequestDispatcher("editerCategorie.jsp").forward(request, response);
        }
        else if (path.equals("/updateCategorie") && request.getMethod().equals("POST")) {
            Date dateCreation = new Date();
            int id = Integer.parseInt(request.getParameter("id"));
            String nom = request.getParameter("nom");
            Categorie categorie = new Categorie();
            categorie.setIdCategorie(id);
            categorie.setNomCategorie(nom);
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            try {
                dateCreation = simpleDateFormat.parse(request.getParameter("dateCreation"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            categorie.setDateCreation(dateCreation);
            metier.updateCategorie(categorie);
            response.sendRedirect("categories");
        }
        else {
            response.sendError(response.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
