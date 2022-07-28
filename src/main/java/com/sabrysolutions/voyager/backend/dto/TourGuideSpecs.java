package com.sabrysolutions.voyager.backend.dto;

import com.sabrysolutions.voyager.backend.models.Profile;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Collection;

public class TourGuideSpecs {

    public static Specification<Profile> findByPlace(String placeName) {

        return (Specification<Profile>) (root, query, cb) -> {
            final Collection<Predicate> predicates = new ArrayList<>();
            Predicate placeNamePredicate=null;
            Predicate cityPredicate=null;

            if (placeName!=null) {
                placeNamePredicate = root.join("workPlaces").get("Place").in(placeName);

                cityPredicate = root.join("workPlaces").get("city").get("name").in(placeName);
            }

            return cb.or(placeNamePredicate,cityPredicate);
        };
    }

    public static Specification<Profile> findByLanguage(String languageName) {

        return (Specification<Profile>) (root, query, cb) -> {
            final Collection<Predicate> predicates = new ArrayList<>();
            if (languageName!=null) {
                predicates.add(cb.equal(root.get("isTourguide"), 1));
                final Predicate appPredicate = root.join("spokenLanguages").get("name").in(languageName);
                predicates.add(appPredicate);
            }

            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }


}
