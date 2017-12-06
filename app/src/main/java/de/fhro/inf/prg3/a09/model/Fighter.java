package de.fhro.inf.prg3.a09.model;

import android.graphics.drawable.Drawable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Peter Kurfer
 */

public abstract class Fighter {

    private final String pilot;
    private final Drawable fighterimage;

    public Fighter(String pilot, Drawable fighterimage) {
        this.pilot = pilot;
        this.fighterimage = fighterimage;
    }

    public String getPilot() {
        return pilot;
    }

    public Drawable getFighterImage() {
        return this.fighterimage;
    }

    public abstract String getFighterType();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Fighter)) return false;

        Fighter fighter = (Fighter) o;

        return new EqualsBuilder()
                .append(getPilot(), fighter.getPilot())
                .append(getFighterType(), fighter.getFighterType())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getPilot())
                .append(getFighterType())
                .toHashCode();
    }
}
