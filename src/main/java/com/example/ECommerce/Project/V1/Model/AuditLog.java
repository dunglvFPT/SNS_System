package com.example.ECommerce.Project.V1.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "auditlog")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class AuditLog extends BaseEntity{

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false, length = 100)
    private String tableName;

    @Column(nullable = false, length = 100)
    private String actionType;

    @Column(nullable = false)
    private LocalDateTime actionTime;

    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String oldValue;

    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String newValue;

    @Column(length = 100)
    private String ipAddress;
}
