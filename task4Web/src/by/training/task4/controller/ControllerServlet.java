package by.training.task4.controller;

import by.training.task4.entity.Medicine;
import by.training.task4.entity.Package;
import by.training.task4.entity.Version;
import by.training.task4.service.factory.MedicineFactory;
import by.training.task4.service.factory.MedicineParserFactory;
import by.training.task4.service.factory.MedicinesAbstractBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Set;

@WebServlet(name = "ControllerServlet")
public class ControllerServlet extends HttpServlet {

 //   private static final Logger LOG = LogManager.getLogger(
   //         ControllerServlet.class);

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String parser = request.getParameter("parser");

        MedicineParserFactory factory;
        MedicinesAbstractBuilder builder;
        Set<Medicine> validMedicinsSet;

        String path = this.getServletContext().getRealPath("/");

        String xmlPath = path + "xml" + File.separator + "Medicines.xml";
        String xsdPath = path + "xml" + File.separator + "Medicines.xsd";

        factory = new MedicineParserFactory();

        StringBuilder sb = new StringBuilder();
        StringBuilder hi = new StringBuilder();

        try {
            builder = factory.getBuilder(parser);
            if(builder.buildSetMedicines(xmlPath, xsdPath)) {
                validMedicinsSet = builder.getMedicins();
                for (Medicine medicine : validMedicinsSet) {
                    int primaRSpan = 0;
                    for (Version version : medicine.getVersions()) {
                        primaRSpan += version.getPackage().size();
                    }

                    sb.append("<tr>");
                    sb.append("<td rowspan=\"" + primaRSpan + "\">"
                            + medicine.getClass().getSimpleName()
                            + "</td>");
                    sb.append("<td rowspan=\"" + primaRSpan + "\">"
                            + medicine.getName()
                            + "</td>");
                    sb.append("<td rowspan=\"" + primaRSpan + "\" nowrap>"
                            + medicine.getCAS()
                            + "</td>");
                    sb.append("<td rowspan=\"" + primaRSpan + "\">"
                            + medicine.getDrugBank()
                            + "</td>");
                    sb.append("<td rowspan=\"" + primaRSpan + "\">"
                            + medicine.getPharm()
                            + "</td>");
                    int versionCounter = 0;
                    for (Version version : medicine.getVersions()) {
                        versionCounter++;
                        int secRSpan = version.getPackage().size();
                        if (versionCounter != 1) {
                            sb.append("<tr>");
                        }
                        DateFormat dateFormat =
                                new SimpleDateFormat("dd-MM-yyyy");
                        String regDate = dateFormat.format(
                                version.getCertificate().getRegistrationDate());
                        String expDate = dateFormat.format(
                                version.getCertificate().getExpirationDate());
                        sb.append("<td rowspan=\"" + secRSpan + "\">"
                                + version.getAnalog()
                                + "</td>");
                        sb.append("<td rowspan=\"" + secRSpan + "\">"
                                + version.getProducer()
                                + "</td>");
                        sb.append("<td rowspan=\"" + secRSpan + "\">"
                                + version.getForm()
                                + "</td>");
                        sb.append("<td rowspan=\"" + secRSpan + "\">"
                                + version.getCertificate().getRegisteredBy()
                                + "</td>");
                        sb.append("<td rowspan=\"" + secRSpan + "\" nowrap>"
                                + regDate
                                + "</td>");
                        sb.append("<td rowspan=\"" + secRSpan + "\" nowrap>"
                                + expDate
                                + "</td>");
                        sb.append("<td rowspan=\"" + secRSpan + "\">"
                                + version.getDosage().getAmount()
                                + "</td>");
                        sb.append("<td rowspan=\"" + secRSpan + "\">"
                                + version.getDosage().getFrequency()
                                + "</td>");
                        int packCounter = 0;
                        for (Package pack : version.getPackage()) {
                            packCounter++;
                            if (packCounter != 1) {
                                sb.append("<tr>");
                            }
                            String size = pack.getSize();
                            sb.append("<td>"
                                    + (size == null ? "Not specified" : size)
                                    + "</td>");
                            sb.append("<td>" + pack.getQuantity() + "</td>");
                            sb.append("<td>" + pack.getPrice() + "</td>");
                            if (packCounter != 1) {
                                sb.append("</tr>");
                            }
                        }
                        if (versionCounter != 1) {
                            sb.append("</tr>");
                        }
                    }
                    sb.append("</tr>");
                }
            }
        } catch (Exception e) {
          //  LOG.error("Exception occurred", e);
        }
        request.setAttribute("parserType", parser);
        request.setAttribute("resultSet", sb);
        request.getRequestDispatcher(
                "/jsp/Result.jsp").forward(request, response);

    }
}
