import React from 'react';
import clsx from 'clsx';
import PropTypes from 'prop-types';
import { makeStyles } from '@material-ui/styles';
import { Card, CardContent, Grid, Typography, Avatar } from '@material-ui/core';
import PostAddIcon from '@material-ui/icons/PostAdd';
import NavigateNextIcon from '@material-ui/icons/NavigateNext';


const useStyles = makeStyles(theme => ({
	root: {
		height: '100%'
	},
	content: {
		alignItems: 'center',
		display: 'flex'
	},
	title: {
		fontWeight: 700
	},
	avatar: {
		backgroundColor: theme.palette.error.main,
		height: 56,
		width: 56
	},
	icon: {
		height: 32,
		width: 32
	},
	difference: {
		marginTop: theme.spacing(2),
		display: 'flex',
		alignItems: 'center',
		justifyContent: 'flex-end',
		borderTop: '0.5px solid #BBBBBB',
		paddingTop: '10px'
	},
	differenceIcon: {
		color: theme.palette.background.toolbar
	},
	differenceValue: {
		color: theme.palette.error.dark,
		marginRight: theme.spacing(1)
	}
}));

const TotalPengadaan = props => {
	const { className, ...rest } = props;

	const classes = useStyles();

	return (
		<Card
			{...rest}
			className={clsx(classes.root, className)}
		>
			<CardContent>
				<Grid
					container
					justify="space-between"
				>
					<Grid item>
						<Typography
							className={classes.title}
							color="textSecondary"
							gutterBottom
							variant="body2"
						>
							PERMINTAAN PENGADAAN
            </Typography>
						<Typography variant="h3">250</Typography>
					</Grid>
					<Grid item>
						<Avatar className={classes.avatar}>
							<PostAddIcon className={classes.icon} />
						</Avatar>
					</Grid>
				</Grid>
				<div className={classes.difference}>
					<NavigateNextIcon className={classes.differenceIcon} />
					<Typography
						className={classes.caption}
						variant="caption"
					>
						Lihat Selengkapnya
          			</Typography>
				</div>
			</CardContent>
		</Card>
	);
};

TotalPengadaan.propTypes = {
	className: PropTypes.string
};

export default TotalPengadaan;
