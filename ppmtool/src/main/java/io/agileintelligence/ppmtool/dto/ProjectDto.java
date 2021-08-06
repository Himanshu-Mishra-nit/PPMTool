package io.agileintelligence.ppmtool.dto;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;
import java.util.UUID;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

@JsonSerialize
@JsonDeserialize(as = ImmutableProjectDto.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Value.Immutable
public interface ProjectDto {
	
	@Nullable
	UUID getId();
	
	@NotNull
	String getName();
	
	@NotNull
	String getIdentifier();
	
	@NotNull
	String getDescription();
	
	@Nullable
	Date getStart_date();
	
	@Nullable
	Date getEnd_date();
	
	@Nullable
	Date getCreated_At();
	
	@Nullable
	Date getUpdated_At();

}
