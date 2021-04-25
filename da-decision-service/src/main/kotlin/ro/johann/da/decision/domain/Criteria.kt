package ro.johann.da.decision.domain

import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "criteria")
data class Criteria(

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  var id: UUID = UUID.randomUUID(),

  @Column(nullable = false)
  var name: String,

  @Column(nullable = false)
  var weight: Int,

  @Column
  var unitOfMeasure: String?,

  @Column
  var type: CriteriaType,

  @Column
  var createdAt: LocalDateTime,

  @Column
  var updatedAt: LocalDateTime,

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "decision_id")
  val decision: Decision,

  @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
  @JoinColumn(name = "criteria_id")
  private val propertyList: MutableList<Property> = mutableListOf()
) {
  val properties: List<Property>
    get() = propertyList
}

//sealed class Criteria() {
//  abstract val id: UUID
//  abstract val name: String
//  abstract val weight: Int
//  abstract val type: CriteriaType
//  abstract val propertyType: PropertyType
//}
//
//class QuantitativeCriteria(
//  override val id: UUID,
//  override val name: String,
//  override val weight: Int,
//  override val propertyType: PropertyType,
//  val quantitativeType: QuantitativeCriteriaType,
//  val unitOfMeasure: String
//): Criteria() {
//  override val type = CriteriaType.QUALITATIVE
//}
//
//class QualitativeCriteria(
//  override val id: UUID,
//  override val name: String,
//  override val weight: Int,
//  override val propertyType: PropertyType,
//  val options: List<QualitativeCriteriaOption>
//): Criteria() {
//  override val type = CriteriaType.QUANTITATIVE
//}
//