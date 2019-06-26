/*
 * class: Certificate
 */

package main.java.task4.model;

import java.util.Date;

/**
 * Represents certificate which refers to concrete medicine version.
 * @author AlesyaHlushakova
 */
public class Certificate {
    /**
     * registered by field.
     */
    private String registeredBy;
    /**
     * registration date.
     */
    private Date registrationDate;
    /**
     * expiration date.
     */
    private Date expireDate;

    /**
     * getter for date.
     * @return string
     */
    public String getRegisteredBy() {
        return registeredBy;
    }

    /**
     * setter.
     * @param newRegisteredBy registered by who.
     */
    public void setRegisteredBy(final String newRegisteredBy) {
        this.registeredBy = newRegisteredBy;
    }

    /**
     * getter for registration date.
     * @return date
     */
    public Date getRegistrationDate() {
        return registrationDate;
    }

    /**
     * setter for registered date.
     * @param newRegistredDate registered date
     */
    public void setRegistrationDate(final Date newRegistredDate) {
        this.registrationDate = newRegistredDate;
    }

    /**
     * getter for expiration date.
     * @return date
     */
    public Date getExpireDate() {
        return expireDate;
    }

    /**
     * setter for expiration date.
     * @param newExpireDate expiration date
     */
    public void setExpireDate(final Date newExpireDate) {
        this.expireDate = newExpireDate;
    }

    /**
     * method overrides equals.
     * @param obj comparable medicine
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
        Certificate certificate = (Certificate) obj;
        if (registeredBy == null) {
            if (certificate.registeredBy != null) {
                return false;
            }
        } else if (!registeredBy.equals(certificate.registeredBy)) {
            return false;
        }
        if (registrationDate == null) {
            if (certificate.registrationDate != null) {
                return false;
            }
        } else if (!registrationDate.
                equals(certificate.registrationDate)) {
            return false;
        }
        if (expireDate == null) {
            if (certificate.expireDate != null) {
                return false;
            }
        } else if (!expireDate.
                equals(certificate.expireDate)) {
            return false;
        }
        return true;
    }

    /**
     * method overrides hash code.
     * @return hash
     */
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode += registeredBy == null ? 0 : registeredBy.hashCode();
        hashCode += registrationDate == null ? 0 : registrationDate.hashCode();
        hashCode += expireDate == null ? 0 : expireDate.hashCode();
        return hashCode;
    }

    /**
     * methos overrides to string.
     * @return string
     */
    @Override
    public String toString() {
        return "\n        " + getClass().getSimpleName() + ":"
                + "\n            registered by:      " + registeredBy
                + "\n            registration date: " + registrationDate
                + "\n            expiration date :      " + expireDate;
    }
}


