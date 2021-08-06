package io.agileintelligence.ppmtool.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;
import java.util.UUID;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@JsonSerialize
@JsonDeserialize(as = ImmutableProjectDto.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Value.Immutable
public interface ProjectDto {
	
	@Nullable
	UUID getId();
	
	@NotNull(message = "Project name is neccessary")
	String getName();
	
	@NotNull(message = "Project Identifier is neccessary")
	@Size(min=4, max=5, message = "Please use 4 to 5 character")
	String getIdentifier();
	
	@NotNull(message = "Project description is neccessary")
	String getDescription();
	
	@Nullable
	@JsonFormat(pattern = "yyyy-mm-dd")
	Date getStart_date();
	
	@Nullable
	@JsonFormat(pattern = "yyyy-mm-dd")
	Date getEnd_date();
	
	@Nullable
	@JsonFormat(pattern = "yyyy-mm-dd")
	Date getCreated_At();
	
	@Nullable
	@JsonFormat(pattern = "yyyy-mm-dd")
	Date getUpdated_At();

}
