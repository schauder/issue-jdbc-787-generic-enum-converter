package de.schauderhaft.enumconverter;

import org.springframework.data.annotation.Id;

record EnumOwner (
	@Id
	Long id,
	Color color,
	Direction direction
){}

enum Color {
	RED,
	BLUE,
	PINK,
	PURPLE
}

enum Direction {
	UP,
	SIDEWAYS,
	ACROSS
}
