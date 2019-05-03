package by.traning.task1.comparator;

import by.traning.task1.entities.Toy;
import by.traning.task1.entities.enums.Age;
import by.traning.task1.entities.enums.Size;

import java.util.Comparator;

public class ToyComparator implements Comparator<Toy> {
    private ComparatorParameter comparatorParameter;

    public ToyComparator(ComparatorParameter comparatorParameter) {
        setComparatorParameter(comparatorParameter);
    }

    private void setComparatorParameter(ComparatorParameter comparatorParameter) {
        if (comparatorParameter == null) {
            throw new IllegalArgumentException("Empty parameter.");
        }

        this.comparatorParameter = comparatorParameter;
    }

    public int compare(Toy first, Toy second) {
        switch (comparatorParameter) {
            case NAME: {
                String firstToyName = first.getName();
                String secondToyName = second.getName();
                int sortingResult = firstToyName.compareTo(secondToyName);

                return sortingResult;
            }
            case SIZE: {
                Size firstToySize = first.getSize();
                Size secondToySize = second.getSize();
                int sortingResult =firstToySize.compareTo(secondToySize);

                return sortingResult;
            }
            case PRICE: {
                double firstToyPrice = first.getPrice();
                double secondToyPrice = second.getPrice();
                int sortingResult = (int) (firstToyPrice - secondToyPrice);

                return sortingResult;
            }
            case AGE: {
                Age firstToyAgeLimit = first.getAge();
                Age secondToyAgelimit = second.getAge();

                int firstLimit = firstToyAgeLimit.getLimit();
                int secondLimit = secondToyAgelimit.getLimit();
                int sortingResult = firstLimit - secondLimit;

                return sortingResult;
            }

            default: {
                throw new EnumConstantNotPresentException(ComparatorParameter.class, comparatorParameter.name());
            }
        }

    }
}