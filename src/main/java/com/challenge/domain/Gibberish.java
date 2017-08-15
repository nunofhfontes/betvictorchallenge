
package com.challenge.domain;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * gibberish
 * <p>
 * gibberish object
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "amount",
    "number",
    "number_max",
    "format",
    "type",
    "text_out"
})
public class Gibberish {

    @JsonProperty("amount")
    private Integer amount;
    @JsonProperty("number")
    private String number;
    @JsonProperty("number_max")
    private String numberMax;
    @JsonProperty("format")
    private String format;
    @JsonProperty("type")
    private String type;
    @JsonProperty("text_out")
    private String textOut;
    @JsonProperty("time")
    private String time;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    
    @JsonIgnore
    public String getTime() {
		return time;
	}

    @JsonIgnore
	public void setTime(String time) {
		this.time = time;
	}

	@JsonProperty("amount")
    public Integer getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @JsonProperty("number")
    public String getNumber() {
        return number;
    }

    @JsonProperty("number")
    public void setNumber(String number) {
        this.number = number;
    }

    @JsonProperty("number_max")
    public String getNumberMax() {
        return numberMax;
    }

    @JsonProperty("number_max")
    public void setNumberMax(String numberMax) {
        this.numberMax = numberMax;
    }

    @JsonProperty("format")
    public String getFormat() {
        return format;
    }

    @JsonProperty("format")
    public void setFormat(String format) {
        this.format = format;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("text_out")
    public String getTextOut() {
        return textOut;
    }

    @JsonProperty("text_out")
    public void setTextOut(String textOut) {
        this.textOut = textOut;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(amount).append(number).append(numberMax).append(format).append(type).append(textOut).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Gibberish) == false) {
            return false;
        }
        Gibberish rhs = ((Gibberish) other);
        return new EqualsBuilder().append(amount, rhs.amount).append(number, rhs.number).append(numberMax, rhs.numberMax).append(format, rhs.format).append(type, rhs.type).append(textOut, rhs.textOut).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
