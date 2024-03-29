package main.java.task4.controller;

import main.java.task4.model.Medicine;
import main.java.task4.model.Package;
import main.java.task4.model.Version;
import main.java.task4.service.factory.MedicinesAbstractParser;
import main.java.task4.service.factory.MedicinesParserFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

/**
 * controller class.
 */
@WebServlet(name = "ControllerServlet")
public class ControllerServlet extends HttpServlet {
    /**
     * logger intro.
     */
    private static final Logger LOG = LogManager.
            getLogger(MedicinesParserFactory.class);

    /**
     * post method.
     * @param request request
     * @param response responce
     * @throws ServletException exception
     * @throws IOException exception
     */
    protected void doPost(final HttpServletRequest request,
                          final HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * get method.
     * @param request request
     * @param response response
     * @throws ServletException exception
     * @throws IOException exception
     */
    protected void doGet(final HttpServletRequest request,
                         final HttpServletResponse response)
            throws ServletException, IOException {

        String parser = request.getParameter("parser");

        MedicinesParserFactory factory;
        MedicinesAbstractParser builder;
        Set<Medicine> validMedicinsSet;

        String path = this.getServletContext().getRealPath("/");

        String xmlPath = path + "xml" + File.separator + "Medicins.xml";
        String xsdPath = path + "xml" + File.separator + "Medicins.xsd";

        factory = new MedicinesParserFactory();

        StringBuilder sb = new StringBuilder();

        try {
            builder = factory.getParser(parser);
            if (builder.buildSetMedicines(xmlPath, xsdPath)) {
                validMedicinsSet = builder.getMedicines();
                for (Medicine medicine : validMedicinsSet) {
                    int primaRSpan = 0;
                    for (Version version : medicine.getVersions()) {
                        primaRSpan += version.getaPackages().size();
                    }
                    sb.append("<tr>");
                    sb.append("<td rowspan=\"" + primaRSpan + "\">"
                            + medicine.getClass().getSimpleName()
                            + "</td>");
                    sb.append("<td rowspan=\"" + primaRSpan + "\">"
                            + medicine.getName()
                            + "</td>");
                    sb.append("<td rowspan=\"" + primaRSpan + "\" nowrap>"
                            + medicine.getCas()
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
                        int secRSpan = version.getaPackages().size();
                        if (versionCounter != 1) {
                            sb.append("<tr>");
                        }
                        DateFormat dateFormat =
                                new SimpleDateFormat("dd-MM-yyyy");
                        String regDate = dateFormat.format(
                                version.getCertificate().getRegistrationDate());
                        String expDate = dateFormat.format(
                                version.getCertificate().getExpireDate());
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
                        for (Package pack : version.getaPackages()) {
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
            LOG.error("Exception occurred", e);
        }
        request.setAttribute("parserType", parser);
        request.setAttribute("resultSet", sb);
        request.getRequestDispatcher(
                "/jsp/result.jsp").forward(request, response);

    }
}
