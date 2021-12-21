package Modelo.MainObjects;

import java.util.Objects;

public class Feature {
    private String feature;

    public Feature(String feature) {
        this.feature = feature;
    }

    @Override
    public boolean equals(Object feature) {
        return (Objects.equals(this.feature, ((Feature) feature).getFeature()));
    }

    public String getFeature() {
        return feature;
    }

    public boolean notDefinite() {
        return feature.isEmpty();
    }
}
