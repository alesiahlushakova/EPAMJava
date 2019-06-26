/*
 * class: Version
 */

package main.java.task4.model;

import java.util.HashSet;

/**
 * Represents concrete version of medicine, it's producer, certificate etc.
 *
 *
 * @author AlesyaHlushakova
 */
public class Version {

    private String analog;
    private String producer;
    private String form;
    private Certificate certificate;
    private HashSet<Package> aPackages;
    private Dosage dosage;
    
    public Version() {
        aPackages = new HashSet<Package>();
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public HashSet<Package> getaPackages() {
        return aPackages;
    }

    public void setaPackages(HashSet<Package> aPackages) {
        this.aPackages = aPackages;
    }

    public Dosage getDosage() {
        return dosage;
    }

    public void setDosage(Dosage dosage) {
        this.dosage = dosage;
    }

    public String getAnalog() {
        return analog;
    }

    public void setAnalog(String tradeName) {
        this.analog = tradeName;
    }
    
    public void addPack(Package pack) {
        aPackages.add(pack);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) { return true; }
        if (obj == null) { return false; }
        if (obj.getClass() != getClass()) { return false; }
        Version version = (Version) obj;
        if (analog == null) {
            if (version.analog != null) {
                return false;
            }
        } else if(!analog.equals(version.analog)) {
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
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode += analog == null ? 0 : analog.hashCode();
        hashCode += producer == null? 0 : producer.hashCode();
        hashCode += form == null ? 0 : form.hashCode();
        hashCode += certificate == null ? 0 : certificate.hashCode();
        hashCode += dosage == null ? 0 : dosage.hashCode();
        for (Package pack : aPackages) {
            hashCode += pack.hashCode();
        }
        return hashCode;
    }
    
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
