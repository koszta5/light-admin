/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.lightadmin.demo.model;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static javax.persistence.TemporalType.DATE;

/**
 * TODO: Document me!
 *
 * @author Maxim Kharchenko (kharchenko.max@gmail.com)
 */
@Entity
public class Job extends JobDomainEntity {

    @NotBlank
    private String name;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "job_type_id")
    private JobType jobType;

    @NotNull
    @Temporal(DATE)
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date scheduledTime;

    @OneToMany(mappedBy = "job", cascade=CascadeType.ALL)
    private List<JobQueue> jobQueues;

    public String getName() {
        return name;
    }

    public JobType getJobType() {
        return jobType;
    }

    public Date getScheduledTime() {
        return scheduledTime;
    }

    public List<JobQueue> getJobQueues() {
        return jobQueues;
    }
}