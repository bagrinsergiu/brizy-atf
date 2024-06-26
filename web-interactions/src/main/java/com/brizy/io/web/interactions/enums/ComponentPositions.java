package com.brizy.io.web.interactions.enums;

import com.brizy.io.web.interactions.dto.editor.container.ComponentDimensionsDto;
import com.brizy.io.web.interactions.dto.editor.container.ElementPositionDto;
import io.vavr.control.Try;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ComponentPositions {

    UNDEFINED {
        @Override
        public ElementPositionDto getPosition(ComponentDimensionsDto size, ElementPositionDto position) {
            return ElementPositionDto.builder()
                    .x((size.getWidth() / 2) + position.getX())
                    .y((size.getHeight() / 2) + position.getY())
                    .build();
        }
    },
    UP {
        @Override
        public ElementPositionDto getPosition(ComponentDimensionsDto size, ElementPositionDto position) {
            return ElementPositionDto.builder()
                    .x((size.getWidth() / 2) + position.getX())
                    .y(position.getY())
                    .build();
        }
    },
    BOTTOM {
        @Override
        public ElementPositionDto getPosition(ComponentDimensionsDto size, ElementPositionDto position) {
            return ElementPositionDto.builder()
                    .x(((size.getWidth() / 2) + position.getX()))
                    .y(size.getHeight() + position.getY())
                    .build();
        }
    },
    RIGHT {
        @Override
        public ElementPositionDto getPosition(ComponentDimensionsDto size, ElementPositionDto position) {
            return ElementPositionDto.builder()
                    .x(size.getWidth() + position.getX())
                    .y((size.getHeight() / 2) + position.getY())
                    .build();
        }
    },
    LEFT {
        @Override
        public ElementPositionDto getPosition(ComponentDimensionsDto size, ElementPositionDto position) {
            return ElementPositionDto.builder()
                    .x(position.getX())
                    .y((size.getHeight() / 2) + position.getY())
                    .build();
        }
    };

    public static ComponentPositions findForString(String value) {
        return Try.of(() -> ComponentPositions.valueOf(value))
                .getOrElse(UNDEFINED);
    }

    public abstract ElementPositionDto getPosition(ComponentDimensionsDto size, ElementPositionDto position);

}
