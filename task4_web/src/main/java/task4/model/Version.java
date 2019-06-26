/*
 * class: Version
 */

package main.java.task4.model;

import java.util.HashSet;

/**
 * Represents concrete version of medicine, it's producer, certificate etc.
 * @author AlesyaHlushakova
 */
public class Version {
    /**
     * analog.
     */
    private String analog;
    /**
     * producer.
     */
    private String producer;
    /**
     * form.
     */
    private String form;
    /**
     * certificate.
     */
    private Certificate certificate;
    /**
     * packages.
     */
    private HashSet<Package> aPackages;
    /**
     * dosage.
     */
    private Dosage dosage;

    /**
     * constructor.
     */
    public Version() {
        aPackages = new HashSet<Package>();
    }

    /**
     * getter for production.
     * @return producer
     */
    public String getProducer() {
        return producer;
    }

    /**
     * setter.
     * @param newProducer producer
     */
    public void setProducer(final String newProducer) {
        this.producer = newProducer;
    }

    /**
     * getter for form.
     * @return form
     */
    public String getForm() {
        return form;
    }

    /**
     * setter for form.
     * @param newForm form
     */
    public void setForm(final String newForm) {
        this.form = newForm;
    }

    /**
     * getter for certificate.
     * @return cert
     */
    public Certificate getCertificate() {
        return certificate;
    }

    /**
     * setter.
     * @param newCertificate certificate
     */
    public void setCertificate(final Certificate newCertificate) {
        this.certificate = newCertificate;
    }

    /**
     * getter for packages.
     * @return package
     */
    public HashSet<Package> getaPackages() {
        return aPackages;
    }

    /**
     * setter for packages.
     * @param newPackages packages
     */
    public void setaPackages(final HashSet<Package> newPackages) {
        this.aPackages = newPackages;
    }

    /**
     * getter for dosage.
     * @return dosage
     */
    public Dosage getDosage() {
        return dosage;
    }

    /**
     * setter for dosage.
     * @param newDosage dosage
     */
    public void setDosage(final Dosage newDosage) {
        this.dosage = newDosage;
    }

    /**
     * getter for analog.
     * @return analog
     */
    public String getAnalog() {
        return analog;
    }

    /**
     * setter for analog.
     * @param newTradeName analog
     */
    public void setAnalog(final String newTradeName) {
        this.analog = newTradeName;
    }

    /**
     * adds package.
     * @param pack package.
     */
    public void addPack(final Package pack) {
        aPackages.add(pack);
    }

    /**
     * overrides equals.
     * @param obj comparable object
     * @return is equal
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Version version = (Version) obj;
        if (analog == null) {
            if (version.analog != null) {
                return false;
            }
        } else if (!analog.equals(version.analog)) {
            return false;
        }
        if (producer == null) {
            if (version.producer != null) {
                return false;
            }
        } else if (!producer.equals(version.producer)) {
            return false;
        }
        if (form == null) {
            if (version.form != null) {
                return false;
            }
        } else if (!form.equals(version.form)) {
            return false;
        }
        if (certificate == null) {
            if (version.certificate != null) {
                return false;
            }
        } else if (!certificate.equals(version.certificate)) {
            return false;
        }
        if (dosage == null) {
            if (version.dosage != null) {
                return false;
            }
        } else if (!dosage.equals(version.dosage)) {
            return false;
        }
        if (aPackages == null) {
            if (version.aPackages != null) {
                return false;
            }
        } else if (!aPackages.equals(version.aPackages)) {
            return false;
        }
        return true;
    }

    /**
     * hash code.
     * @return hash
     */
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode += analog == null ? 0 : analog.hashCode();
        hashCode += producer == null ? 0 : producer.hashCode();
        hashCode += form == null ? 0 : form.hashCode();
        hashCode += certificate == null ? 0 : certificate.hashCode();
        hashCode += dosage == null ? 0 : dosage.hashCode();
        for (Package pack : aPackages) {
            hashCode += pack.hashCode();
        }
        return hashCode;
    }

    /**
     * to string.
     * @return string
     */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(
                "\n    " + getClass().getSimpleName() + ":"
                + " analog='" + analog + "'"
                + "\n        producer: " + producer
                + "\n        form :    " + form
                + certificate
                + dosage);
        for (Package pack : aPackages) {
            output.append(pack);
        }
        return output.toString();
    }
}


