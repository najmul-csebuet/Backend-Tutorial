package com.example.QuerydslJpaKotlin

import lombok.Getter
import lombok.Setter
import javax.persistence.Entity

@Entity
@Getter
@Setter
class Test {
    var id = ""
    var name = ""
}