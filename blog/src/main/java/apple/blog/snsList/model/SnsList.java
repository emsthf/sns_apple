package apple.blog.snsList.model;

import apple.blog.sns.model.Sns;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class SnsList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "sns_id")
    private Sns sns;

    public Sns getSns() {
        return sns;
    }

    @Builder
    public SnsList(Sns sns) {
        this.sns = sns;
    }
}
