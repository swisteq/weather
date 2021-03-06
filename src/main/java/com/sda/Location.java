    package com.sda;

    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;

    import javax.persistence.Entity;
    import javax.persistence.GeneratedValue;
    import javax.persistence.GenerationType;
    import javax.persistence.Id;
    import java.time.Instant;

    @Entity
    @Getter
    @Setter
    @NoArgsConstructor
    public class Location {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String city;
        private String region;
        private String country;
        private Integer longitude;
        private Integer latitude;
        private Instant createdDate;
    }
