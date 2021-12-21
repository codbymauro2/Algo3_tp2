package Modelo.MainObjects;

import java.util.Objects;

public class Feature {
    private String element;

    public Feature(String feature) {
        this.element = feature;
    }

    @Override
    public boolean equals(Object feature) {
        return (Objects.equals(this.element, ((Feature) feature).getFeature()));
    }

    public String getFeature() {
        return element;
    }

    public boolean notDefinite() {
        return element.isEmpty();
    }
}
